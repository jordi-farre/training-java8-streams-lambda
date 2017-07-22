package training.java8.order.dto;

import java.time.LocalDate;
import java.util.Comparator;

import training.java8.order.entity.Audit.Action;

import static java.util.Comparator.comparing;

public class AuditDto implements Comparable{
	private final Comparator comparator =
			comparing(AuditDto::getDate).reversed()
			.thenComparing(comparing(AuditDto::getAction))
			.thenComparing(comparing(AuditDto::getUsername));

	public String username;
	public LocalDate date;
	public Action action;

	public final LocalDate getDate() {
		return date;
	}
	public final Action getAction() {
		return action;
	}
	public final String getUsername() {
		return username;
	}

	@Override
	public int compareTo(Object other) {
		return comparator.compare(this, other);
	}
}
