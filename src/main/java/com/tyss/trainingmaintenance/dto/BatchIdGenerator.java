package com.tyss.trainingmaintenance.dto;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.sound.midi.MidiDevice.Info;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;


@Component
public class BatchIdGenerator implements IdentifierGenerator {



//    String prefix = "java";
//        Connection connection = session.connection();
//
//        try {
//            Statement statement=connection.createStatement();
//
//            ResultSet rs=statement.executeQuery("select count(Batch_Code) as Id from Training_Maintenance.Batch_Info");
//
//            if(rs.next())
//            {
//                int id=rs.getInt(1)+101;
//                String generatedId =new Integer(id).toString();
//                System.out.println("Generated Id: " + generatedId);
//                return generatedId;
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//
//        return null;
//    }

	static BatchInfo binfo;
	 

	private final String DEFAULT_SEQUENCE_NAME = "hibernate_sequence";
	Scanner sc = new Scanner(System.in);
	Serializable result = null;
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	public boolean generate(BatchInfo batch) {
		binfo = batch;
		return true;
		
	}
	
	
	public  Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		

			try {
				connection = session.connection();
				statement = connection.createStatement();
				try {
					int next_val=100;
					statement.executeUpdate("UPDATE " + DEFAULT_SEQUENCE_NAME + " SET next_val=next_val+1");
					resultSet = statement.executeQuery("SELECT next_val FROM  " + DEFAULT_SEQUENCE_NAME);
				} catch (Exception e) {

					System.out.println("In catch, cause : Table is not available.");

					statement.execute("CREATE table " + DEFAULT_SEQUENCE_NAME + " (next_val INT NOT NULL)");
					statement.executeUpdate("INSERT INTO " + DEFAULT_SEQUENCE_NAME + " VALUES(0)");
					statement.executeUpdate("UPDATE " + DEFAULT_SEQUENCE_NAME + " SET next_val=LAST_INSERT_ID(next_val+1)");
					resultSet = statement.executeQuery("SELECT next_val FROM  " + DEFAULT_SEQUENCE_NAME);
				}
				if (resultSet.next()) {
					System.out.println(resultSet.getInt(1));
//					String type=resultSet.getString(6);
						String prefix = "TY_TechElevate_"+binfo.getClient()+"_"+binfo.getTechnology()+"_";
					int nextValue = resultSet.getInt(1);
					String suffix = String.format("%01d", nextValue);
					result = prefix.concat(suffix);
					System.out.println("Custom generated sequence is : " + result);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		

	}

}
