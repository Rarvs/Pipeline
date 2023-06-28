package util;

import instructions.*;
import model.Instruction;
import model.InstructionMemory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;

public class Compile {
    private InstructionMemory instructionMemory;

    public Compile(){
        instructionMemory = InstructionMemory.getInstance();
    }

    public void fetch() {
        try (BufferedReader br = new BufferedReader(new FileReader("/home/rarvs/IdeaProjects/Pipeline/src/input.txt"))) {
            String line;
            int instructionAddress = 0;

            while ((line = br.readLine()) != null) {
                Instruction instruction = decodeInstruction(line);
                instructionMemory.setInstruction(instructionAddress, instruction);
                instructionAddress += 1; // Incrementa o endereço da instrução em 4 bytes
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Instruction decodeInstruction(String line) {
        String[] tokens = line.replaceAll("[,(|)$]",  " ").split("\\s+");
        String opcode = tokens[0];

        System.out.println(Arrays.toString(tokens));

        int rd;
        int offset;
        int rs;
        int rt;
        int address;

        switch (opcode) {
            case "get_tc" -> {
                address = Integer.parseInt(tokens[1]);
                return new GetTc(address);
            }
            case "lw" -> {
                try {
                    rt = Integer.parseInt(tokens[1]);
                } catch (NumberFormatException e) {
                    rt = tokens[1].equals("lo") ? 33 : 32;
                }
                offset = Integer.parseInt(tokens[2]);
                rs = Integer.parseInt(tokens[3]);
                return new LoadWord(rt, rs, offset);
            }
            case "sw" -> {
                try {
                    rt = Integer.parseInt(tokens[1]);
                } catch (NumberFormatException e) {
                    rt = tokens[1].equals("lo") ? 33 : 32;
                }
                offset = Integer.parseInt(tokens[2]);
                rs = Integer.parseInt(tokens[3]);
                return new StoreWord(rt, rs, offset);
            }
            case "add" -> {
                rd = Integer.parseInt(tokens[1]);
                rs = Integer.parseInt(tokens[2]);
                rt = Integer.parseInt(tokens[3]);
                return new Add(rd, rs, rt);
            }
            case "sub" -> {
                rd = Integer.parseInt(tokens[1]);
                rs = Integer.parseInt(tokens[2]);
                rt = Integer.parseInt(tokens[3]);
                return new Subtract(rd, rs, rt);
            }
            case "beq" -> {
                rs = Integer.parseInt(tokens[1]);
                rt = Integer.parseInt(tokens[2]);
                offset = Integer.parseInt(tokens[3]);
                return new Beq(rs, rt, offset);
            }
            case "bne" -> {
                rs = Integer.parseInt(tokens[1]);
                rt = Integer.parseInt(tokens[2]);
                offset = Integer.parseInt(tokens[3]);
                return new Bne(rs, rt, offset);
            }
            case "j" -> {
                address = Integer.parseInt(tokens[1]);
                return new Jump(address);
            }
            case "jr" -> {
                rs = Integer.parseInt(tokens[1]);
                return new JumpRegister(rs);
            }
            case "div" -> {
                rd = Integer.parseInt(tokens[1]);
                rs = Integer.parseInt(tokens[2]);
                rt = Integer.parseInt(tokens[3]);
                return new Div(rd, rs, rt);
            }
            case "mult" -> {
                rd = Integer.parseInt(tokens[1]);
                rs = Integer.parseInt(tokens[2]);
                rt = Integer.parseInt(tokens[3]);
                return new Mult(rd, rs, rt);
            }
            case "bltz" -> {
                rs = Integer.parseInt(tokens[1]);
                offset = Integer.parseInt(tokens[2]);
                return new Bltz(rs, 0, offset);
            }
            case "bgtz" -> {
                rs = Integer.parseInt(tokens[1]);
                offset = Integer.parseInt(tokens[2]);
                return new Bgtz(rs, 0, offset);
            }
            case "noop" -> {
                return new Noop();
            }
            default -> throw new IllegalArgumentException("Opcode inválido: " + opcode);
        }
    }

}
