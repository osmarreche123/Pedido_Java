package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities_enum.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (dd/mm/yyyy): ");
		String txtbirthDate = sc.next();
		Date birthDate = sdf.parse(txtbirthDate);
		
		Client client = new Client(name, email, birthDate);
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.next();
		System.out.println("How many items to this order? ");
		int N = sc.nextInt();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		sc.nextLine();
		for(int i = 0; i < N; i++) {
			System.out.println("Enter #" + (i+1) + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			sc.nextLine();
			
			Product product = new Product(productName, productPrice);
			OrderItem item = new OrderItem(productQuantity, productPrice, product);
			order.addItem(item);
			
		}
		
		System.out.println("ORDER SUMMARY:");
		System.out.print("Order momment: ");
		System.out.println(sdf1.format(order.getMoment()));
		System.out.print("Order Status: ");
		System.out.println(order.getStatus());
		System.out.println(order.getClient().toString());
		System.out.println("Order items: ");
		
		for (OrderItem item : order.getItems()) {
			System.out.println(item.toString());
		}
		
		System.out.println(String.format("%.2f", order.total()));
		
		
		
		
		
		
		
	

		
		sc.close();
	}

}
