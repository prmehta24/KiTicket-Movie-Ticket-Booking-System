package mp1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author parth
 */
public class MD5 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the password : ");
        String name= sc.nextLine();
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(name.getBytes(),0,name.length());
            System.out.println("hashed Password : "+ new BigInteger(1,md.digest()).toString(16));
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }
}
