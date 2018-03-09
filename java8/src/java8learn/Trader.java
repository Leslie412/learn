package java8learn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Trader {
	private final String name;
	private final String city;

	public Trader(String n, String c) {
		this.name = n;
		this.city = c;
	}

	public String getName() {
		return this.name;
	}

	public String getCity() {
		return this.city;
	}

	public String toString() {
		return "Trader:" + this.name + " in " + this.city;
	}

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");

		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// 1. Find all transactions in the year 2011 and sort them by value (high to
		// small).
		transactions.stream().filter(d -> d.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue).reversed()).forEachOrdered(System.out::println);

		// 2. What are all the unique cities where the traders work?
		transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);

		// 3. Find all traders from Cambridge and sort them by name.
		transactions.stream().filter(d -> d.getTrader().getCity().equals("Cambridge"))
				.sorted(Comparator.comparing((Transaction t) -> t.getTrader().getName())).forEach(System.out::println);

		// 4. Return a string of all tradersÅf names sorted alphabetically.
		String str = transactions.stream().map(d -> d.getTrader().getName()).distinct().sorted().collect(Collectors.joining(","));
		System.out.println(str);
		
		// 5. Are any traders based in Milan?
		boolean result = transactions.stream().map(d -> d.getTrader().getCity()).anyMatch(s -> s.equals("Milan"));
		System.out.println(result);
		
		// 6. Print all transactionsÅf values from the traders living in Cambridge.
		transactions.stream().filter(d -> d.getTrader().getCity().equals("Cambridge")).forEach(t -> System.out.println(t.getValue()));
		
		// 7. WhatÅfs the highest value of all the transactions?
		Optional<Transaction> max = transactions.stream().max(Comparator.comparing(Transaction::getValue));
		max.ifPresent(d -> System.out.println("highest value:" + d.getValue()));
		
		// 8. Find the transaction with the smallest value.
		Optional<Transaction> smallest0 = transactions.stream().min(Comparator.comparing(Transaction::getValue));
		Optional<Transaction> smallest = transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
		smallest0.ifPresent(System.out::println);
		smallest.ifPresent(System.out::println);
	}
}
