package TestAutomation.selenium.DataBaseTesting;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DatabaseTest {
	Connection con;
	
	
	
	@BeforeTest
	public void setup() throws SQLException
	{
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","12345");
		
		
	}
	
	@Test
	public void testFunction_countNumberOfLanguagesInACountry_presence() throws SQLException
	{
		Statement statement=con.createStatement();
	    String query="show function status where name='countNumberOfLanguagesInACountry'";
	    ResultSet result=statement.executeQuery(query);
	    String nameOfFunction="";
	    while(result.next())
	    {
	     nameOfFunction=result.getString("Name");
	    }
	    assertEquals(nameOfFunction,"countNumberOfLanguagesInACountry");
	}
	
	
	
	
	@Test
	public void testFunction_countNumberOfLanguagesInACountry_Functionality() throws SQLException
	{
		 CallableStatement call = con.prepareCall("{? = call countNumberOfLanguagesInACountry(?)}");
		 call.registerOutParameter(1, Types.INTEGER);
		 call.setString(2, "IND");
		 call.execute();
		 int count=call.getInt(1);
		 
		     Statement statement=con.createStatement();
		    String query="select count(Language) from countrylanguage where countrycode='IND' ;";
		    ResultSet result=statement.executeQuery(query);
		    int actual_Count=0;
		   
		    
		    while(result.next())
		    {
		     
		    	actual_Count=result.getInt(1);
		     }
		    
		  
		 assertEquals(actual_Count,count);
	}
	
	@Test
	public void testFunction_countNumberOfLanguagesInACountryIsinWorldSchema() throws SQLException
	{
		Statement statement=con.createStatement();
	    String query="show function status where name='countNumberOfLanguagesInACountry'";
	    ResultSet result=statement.executeQuery(query);
	    String nameOfSchema="";
	    while(result.next())
	    {
	    	nameOfSchema=result.getString("Db");
	    }
	    assertEquals(nameOfSchema,"world");
	}
	@Test
	public void testTables() throws SQLException
	{
		String[] tableName=new String[] {"city","country","countrylanguage","employee"};
		Statement statement=con.createStatement();
	    String query="show tables";
	    boolean flag=false;
	    
	    ResultSet result=statement.executeQuery(query);
	    int index=0;
	    while(result.next())
	    {
	     flag=true;
	     String table=result.getString(1);
	     assertEquals(tableName[index],table);
	     index++;
	    }
	    assertTrue(true);
	    
	}
	@Test
	public void testNumberofcolumnsInACityTable() throws SQLException
	{
		Statement statement=con.createStatement();
	    String query="select count(*) as NumberoFColumns from Information_Schema.columns where table_schema=\"world\" and table_name=\"city\";";
	    ResultSet result=statement.executeQuery(query);
	    int count=0;
	   
	    
	    while(result.next())
	    {
	     
	    	count=result.getInt("NumberoFColumns");
	     }
	    assertEquals(count,5);
	
	}
	
	@Test
	public void testColumnNamesInACityTable() throws SQLException
	{
		String[] columnNames= {"ID","Name","CountryCode","District","Population"};
		boolean flag=false;
		Statement statement=con.createStatement();
	    String query="select column_name as ColumnNames from Information_Schema.columns where table_schema='world' and table_name='city\';";
	    	
	    ResultSet result=statement.executeQuery(query);
	    
	   int index=0;
	    
	    while(result.next())
	    {
	    	flag=true;
	     
	    	String columnName=result.getString("ColumnNames");
	    	assertEquals(columnName,columnNames[index]);
	    	index++;
	    	
	     }
	    assertTrue(true);
	}
	
	@Test
	public void testColumsDataTypeInACityTable() throws SQLException
	{
		String[] columnNames= {"ID","Name","CountryCode","District","Population"};
		String[] dataTypes= {"int","char","char","char","int"};
		boolean flag=false;
		Statement statement=con.createStatement();
		String query="select Column_Name,Data_type from Information_Schema.columns where table_schema='world' and table_name='city';";
		 ResultSet result=statement.executeQuery(query);
		    
		   int index=0;
		    
		    while(result.next())
		    {
		    	flag=true;
		     
		    	String columnName=result.getString(1);
		    	String dataType=result.getString(2);
		    	assertEquals(columnName,columnNames[index]);
		    	assertEquals(dataType,dataTypes[index]);
		    	index++;
		    	
		     }
		    assertTrue(true);
		}
	
	@Test
	public void testCharacterMaximunLengthInACityTable() throws  SQLException
	{
		String[] columnNames= {"ID","Name","CountryCode","District","Population"};
		String[] dataTypesLength= {null,"35","3","20",null};
		boolean flag=false;
		Statement statement=con.createStatement();
		String query="select Column_Name,character_maximum_length from Information_Schema.columns where table_schema='world' and table_name='city';";
		 ResultSet result=statement.executeQuery(query);
		    
		   int index=0;
		    
		    while(result.next())
		    {
		    	flag=true;
		     
		    	String columnName=result.getString(1);
		    	String dataTypeLength=result.getString(2);
		    	assertEquals(columnName,columnNames[index]);
		    	assertEquals(dataTypeLength,dataTypesLength[index]);
		    	index++;
		    	
		     }
		    assertTrue(true);
		}
	
	@Test
	public void testColumnsIsNullableOrNotInACityTable() throws  SQLException
	{
		String[] columnNames= {"ID","Name","CountryCode","District","Population"};
		String[] isNullable= {"NO","NO","NO","NO","NO"};
		boolean flag=false;
		Statement statement=con.createStatement();
		String query="select Column_Name,is_Nullable from Information_Schema.columns where table_schema='world' and table_name='city';";
		 ResultSet result=statement.executeQuery(query);
		    
		   int index=0;
		    
		    while(result.next())
		    {
		    	flag=true;
		     
		    	String columnName=result.getString(1);
		    	String nullableResult=result.getString(2);
		    	
		    	assertEquals(columnName,columnNames[index]);
		    	assertEquals(nullableResult,isNullable[index]);
		    	
		    	index++;
		    	
		     }
		    assertTrue(true);
		}
	
		
	
	
	@Test
	public void  testProcedureName() throws SQLException
	{
		Statement statement=con.createStatement();
	    String query="show procedure status where name='addcitytocityList'";
	    ResultSet result=statement.executeQuery(query);
	   
	    
	    while(result.next())
	    {
	     String procedure_Name=result.getString("Name");
	     assertEquals("addcitytocityList", procedure_Name);
	    
	    }
	}   
	
	@Test
	public void testProducerCityCountByCountry() throws SQLException
	{

    	CallableStatement call=con.prepareCall("{call cityCountsByCountry(?,?,?)}");
    	call.setString(1,"AFG");
    	call.registerOutParameter(2,Types.INTEGER);
    	call.registerOutParameter(3,Types.INTEGER);
    	call.executeQuery();
    	
    	int cityCount=call.getInt(2);
    	int countryCount=call.getInt(3);
    	
    	 Statement statement=con.createStatement();
    	 
    	 ResultSet actualCityresult=statement.executeQuery("Select count(*) from city where countrycode='AFG'");
    	 actualCityresult.next();
    	 int expectedCityCount=actualCityresult.getInt(1);
    	 
    	 
    	 ResultSet actualCountryresult=statement.executeQuery("Select count(*) from country");
    	 actualCountryresult.next();
    	 int expectedCountryCount=actualCountryresult.getInt(1);
    	 
    	 assertEquals(cityCount,expectedCityCount);
    	 assertEquals(countryCount,expectedCountryCount);
    	 
    	 
    	

    	
		
	}
	
	//@Test
	public void testTrigger() throws SQLException
	{
		 Statement statement=con.createStatement();
		 String id="25";
    	String query="insert into employee values("+id+",'Hemanth',22,1,'Bng')";
    	statement.execute(query);
    	
    	
    	String query1="select * from employee where id="+id;
    	ResultSet result=statement.executeQuery(query1);
    	String city="";
    	 while(result.next())
    	 {
    		 city=result.getString("city");
    		 
    	 }
    	 
    	 assertEquals(city,"Hyd");
		
	}
	    @Test
	    public void testCityDetailsProcedureColumnValues() throws SQLException
	    {
	    	CallableStatement call=con.prepareCall("{call citydetails}");
	    	 ResultSet result=call.executeQuery();
	    	 Statement statement=con.createStatement();
	    	 ResultSet actualresult=statement.executeQuery("Select * from city");
	    	 assertTrue(copmareResultSet(result,actualresult));
	    	
	    }
	    
	    @Test
	    public void testCityByCountryProcedureColumnValues() throws SQLException
	    {
	    	CallableStatement call=con.prepareCall("{call cityByCountry(?)}");
	    	call.setString(1,"AFG");
	    	 ResultSet result=call.executeQuery();
	    	 Statement statement=con.createStatement();
	    	 ResultSet actualresult=statement.executeQuery("Select * from city where countrycode='AFG'");
	    	 assertTrue(copmareResultSet(result,actualresult));
	    }
	    
	    
	private boolean copmareResultSet(ResultSet rs1, ResultSet rs2) throws SQLException {
		try {
			while (rs1.next()) {
				rs2.next();
				int count = rs1.getMetaData().getColumnCount();
				for (int i = 1; i <= count; i++) {
					if (!rs1.getString(i).equals(rs2.getString(i))) {
						return false;
					}
				}
			}
		} catch (Exception ex) {
			return false;
		}

		return true;

	}
	
	@AfterClass
	public void closeConnection() throws SQLException
	{
		con.close();
	}
}
