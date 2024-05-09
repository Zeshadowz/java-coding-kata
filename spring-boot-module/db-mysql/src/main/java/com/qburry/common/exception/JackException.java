package com.qburry.common.exception;

import lombok.Getter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Getter
public class JackException extends RuntimeException {
    private final Set<Fault> faults = new HashSet<>();

    public JackException(Set<Fault> faults) {
        super(extractMessage(faults));
        this.faults.addAll(faults);
    }

    public JackException(Fault fault) {
        super(extractMessage(fault));
        this.faults.add(fault);
    }

    public JackException(Fault fault, Throwable cause) {
        super(extractMessage(fault), cause);
        this.faults.add(fault);
    }

    private static String extractMessage(Fault fault) {
        return extractMessage(Optional.ofNullable(fault).map(Set::of).orElse(Set.of()));
    }

    private static String extractMessage(Set<Fault> faults) {
        Objects.requireNonNull(faults, "faults cannot be null");

        return faults.stream()
                .map(Fault::getMessage)
                .reduce("", (m1, m2) -> m1 + " | " + m2);
    }

    private static String toMessage(Fault fault) {
        if (fault == null || fault.getFaultType() == null) {
            return null;
        }

        String message = fault.getFaultType().name();
        message += ": " + fault.getMessage();

        return message;
    }

}
