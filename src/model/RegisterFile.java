package model;

import java.util.HashMap;
import java.util.Map;

public class RegisterFile {
    private static RegisterFile instance;

    private Map<Integer, Register> registers;

    private RegisterFile() {
        registers = new HashMap<>();
        initializeRegisters();
    }

    public static RegisterFile getInstance() {
        if (instance == null) {
            instance = new RegisterFile();
        }
        return instance;
    }

    private void initializeRegisters() {
        // Inicializa os registradores
        for (int i = 0; i <= 31; i++) {
            registers.put(i, new Register());
        }
        registers.put(32, new Register()); // Registrador $lo
        registers.put(33, new Register());// Registrador $hi
        setRegisterValue(0, 0);
    }

    public void setRegisterValue(int registerNumber, int value) {
        Register register = registers.get(registerNumber);
        if (register != null) {
            register.setValue(value);
        } else {
            throw new IllegalArgumentException("Register does not exist: $" + registerNumber);
        }
    }

    public int getRegisterValue(int registerNumber) {
        Register register = registers.get(registerNumber);
        if (register != null) {
            return register.getValue();
        } else {
            throw new IllegalArgumentException("Register does not exist: $" + registerNumber);
        }
    }

    // Outros métodos relevantes para o RegisterFile...

    private class Register {
        private int value;

        public Register() {
            this.value = 0;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
