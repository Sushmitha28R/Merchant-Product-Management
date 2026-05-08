package org.jsp.MerchantProductAppController;

import java.util.List;
import java.util.Scanner;
import org.jsp.MerchantProductAppdao.MerchantDao;
import org.jsp.MerchantProductAppdao.ProductDao;
import org.MerchantProductAppDto.Merchant;
import org.MerchantProductAppDto.Product;
public class MerchantProductController {
    static Scanner sc=new Scanner(System.in);
    static MerchantDao mdao=new MerchantDao();
    static ProductDao pdao=new ProductDao();
    public static void main(String[] args) {
        System.out.println("1.Save Merchant Info");
        System.out.println("2.Update Merchant");
        System.out.println("3.Find Merchant By Id");
        System.out.println("4.Find Merchant By Email and Password");
        System.out.println("5.Verify Merchant By phone and Password");
        System.out.println("6.AddProduct");
        System.out.println("7.Update Product");
        System.out.println("8.Find Product By Id");
        System.out.println("9.Find Product By Brand and Category");
        System.out.println("10.Find Product By Merchant Id");
        System.out.println("11.DeleteMer");
        System.out.println("12.DeletePro");
        System.out.println("enter the choice");
        int choice =sc.nextInt();
        switch(choice) {
            case 1:saveMerchant();
                break;
            case 2:updateMerchant();
                break;
            case 3:findMerchantById();
                break;
            case 4:findMerchantByEmailAndPassword();
                break;
            case 5:verifyMerchantByPhoneAndPassword();
                break;
            case 6:addProduct();
                break;
            case 7:UpdateProduct();
                break;
            case 8:FindProductById();
                break;
            case 9:FindProductByBrandAndCategory();
                break;
            case 10:FindProductByMerchantId();
                break;
            case 11:DeleteMer();
                break;
            case 12:DeletePro();
                break;

        }
    }
    private static void FindProductByMerchantId() {
        System.out.println("Enter Merchant id to find Products");
        int mid=sc.nextInt();
        List<Product> mdb=pdao.findProductByMerchantId(mid);
        if(mdb.size()>0) {
            for (Product product : mdb) {
                System.out.println(product);
            }
        }
        else {
            System.out.println("No products are found since Merchant id is invalid");
        }
    }

    private static void FindProductByBrandAndCategory() {
        System.out.println("Enter the Brand:");
        String br=sc.next();
        System.out.println("Enter the Category:");
        String ca=sc.next();
        Product mdb=pdao.FindProductByBrandAndCategory(br,ca);
        if(mdb!=null) {
            System.out.println(mdb);
        }else {
            System.out.println("no record");
        }

    }

    private static void FindProductById() {
        System.out.println("Enter the Product id");
        int mid=sc.nextInt();
        Product mdb=pdao.FindProductById(mid);
        if(mdb!=null) {
            System.out.println(mdb);
        }
        else {
            System.out.println("no record");
        }
    }

    private static void UpdateProduct() {
        System.out.println("Update the Product info..id,.name,brand,category,cost");
        Product  p=new Product();
        p.setId(sc.nextInt());
        p.setName(sc.next());
        p.setBrand(sc.next());
        p.setCategory(sc.next());
        p.setCost(sc.nextDouble());


        Product mdb=pdao.updateProduct(p);
        if(mdb!=null) {
            System.out.println("Merchant info is update with id"+mdb.getId());
        }
        else {
            System.out.println("no record updated since id is invalid");
        }
    }

    private static void addProduct() {

        System.out.println("insert product info..name,brand,category,cost");
        Product p=new Product();
        p.setName(sc.next());
        p.setBrand(sc.next());
        p.setCategory(sc.next());
        p.setCost(sc.nextDouble());
        Product pdb=pdao.addProduct(p);
        System.out.println("Product record is inserted with id"+pdb.getId());
    }
    private static void DeleteMer() {
        System.out.println("Enter id:");
        int mid=sc.nextInt();
        Merchant mdb=mdao.Delete(mid);
        if(mdb!=null) {
            System.out.println("deleted");
        }
        else {
            System.out.println("no record delete");
        }


    }

    private static void DeletePro() {
        System.out.println("Enter id:");
        int mid=sc.nextInt();
        Product pdb=pdao.Delete(mid);
        if(pdb!=null) {
            System.out.println("deleted");
        }
        else {
            System.out.println("no record delete");
        }


    }

    private static void verifyMerchantByPhoneAndPassword() {
        System.out.println("Enter Phone Number:");
        long ph=sc.nextLong();
        System.out.println("Enter the Password:");
        String ps=sc.next();
        Merchant mdb=mdao.verifyMerchantByPhoneAndPassword(ph, ps);
        if(mdb!=null) {
            System.out.println(mdb);
        }else {
            System.out.println("no record");
        }

    }
    private static void findMerchantByEmailAndPassword() {
        System.out.println("Enter the Email:");
        String em=sc.next();
        System.out.println("Enter the Password:");
        String ps=sc.next();
        Merchant mdb=mdao.findMerchantByEmailAndPassword(em,ps);
        if(mdb!=null) {
            System.out.println(mdb);
        }else {
            System.out.println("no record");
        }

    }
    private static void findMerchantById() {
        System.out.println("Enter the Merchant id");
        int mid=sc.nextInt();
        Merchant mdb=mdao.findMerchantById(mid);
        if(mdb!=null) {
            System.out.println(mdb);
        }
        else {
            System.out.println("no record");
        }
    }



    private static void updateMerchant() {
        System.out.println("Update the Merchant info..id,name,gst_num,email,phone,password");
        Merchant m=new Merchant();
        m.setId(sc.nextInt());
        m.setName(sc.next());
        m.setEmail(sc.next());
        m.setGst_num(sc.next());
        m.setPhone(sc.nextLong());
        m.setPassword(sc.next());

        Merchant mdb=mdao.updateMerchant(m);
        if(mdb!=null) {
            System.out.println("Merchant info is update with id"+mdb.getId());
        }
        else {
            System.out.println("no record updated since id is invalid");
        }
    }

    private static void saveMerchant() {
        System.out.println("Insert the Merchant info..name,gst_num,email,phone,password");
        Merchant m=new Merchant();

        m.setName(sc.next());
        m.setEmail(sc.next());
        m.setGst_num(sc.next());
        m.setPhone(sc.nextLong());
        m.setPassword(sc.next());

        Merchant mdb=mdao.saveMerchant(m);
        System.out.println("Merchant record is inserted with id"+mdb.getId());
    }
}
