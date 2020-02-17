package com;

import org.junit.*;

import static org.junit.Assert.*;


public class ConnectionStrTest {

    private static ConnectionStr connstr = new ConnectionStr();

    @Test
    public void testOneEmpty() {
        assertEquals("", connstr.process("1"));
    }
    @Test
    public void testTwoEmpty() {
        assertEquals("", connstr.process("01"));
    }

    @Test
    public void testMinimumExistValue() {
        assertEquals("G H I", connstr.process("4"));
    }

    @Test
    public void testThreeConn() {
        assertEquals("GJM GJN GJO GKM GKN GKO GLM GLN GLO HJM HJN HJO HKM HKN" +
                " HKO HLM HLN HLO IJM IJN IJO IKM IKN IKO ILM ILN ILO", connstr.process("456"));
    }

    @Test
    public void testSameVal() {
        assertEquals("DDD DDE DDF DED DEE DEF DFD DFE DFF EDD EDE EDF" +
                " EED EEE EEF EFD EFE EFF FDD FDE FDF FED FEE FEF FFD FFE FFF", connstr.process("333"));
    }

    @Test
    public void testOutOfRange() {
        assertEquals("", connstr.process("01234567890"));
    }

    @Test
    public void testIllegal() {
        assertEquals("", connstr.process("asd"));
    }


    //----------≤‚ ‘–Ë«Û∂˛------
    @org.junit.Test
    public void testEmptyNum() {
        assertEquals("", connstr.process1("10"));
    }

    @org.junit.Test
    public void testReatNum() {
        assertEquals("GHI GHI", connstr.process1("44"));
    }

    @org.junit.Test
    public void testMax() {
        assertEquals("WXYZ WXYZ", connstr.process1("99"));
    }

    @Test
    public void testIllegal2() {
        assertEquals("", connstr.process("asd"));
    }
}