package com.example.open.testsastrawi;

import com.example.open.testsastrawi.model.Marine;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Rahardyan on 12/16/2017.
 */

public class MarineTest {
    private Marine marine;
    private List<String> greetingMock = new ArrayList<>();
    private List<String> nameResponseMock = new ArrayList<>();
    @Before
    public void setup() {
        marine = Marine.getInstance();

        greetingMock.add("Halo");
        greetingMock.add("Hai");
        greetingMock.add("ada yang bisa dibantu ?");

        nameResponseMock.add("Nama saya Marine");
        nameResponseMock.add("saya Marine");
        nameResponseMock.add("Marine");
    }

    @Test
    public void testGreetings() {
        assertEquals(marine.getGreeting("Assalamualaikum"), "Waalaikumussalam");
        assertTrue(greetingMock.contains((marine.getGreeting("halo"))));
    }

    @Test
    public void testNameResponse() {
        assertTrue(nameResponseMock.contains(marine.getResponse("nama kamu siapa ?")));
        assertTrue(nameResponseMock.contains(marine.getResponse("siapa namamu ?")));
        assertTrue(nameResponseMock.contains(marine.getResponse("siapa nama kamu ?")));
        assertTrue(nameResponseMock.contains(marine.getResponse("siapa nama mu ?")));
        assertTrue(nameResponseMock.contains(marine.getResponse("namamu siapa ?")));
        assertTrue(nameResponseMock.contains(marine.getResponse("siapa kamu ?")));
        assertTrue(nameResponseMock.contains(marine.getResponse("kamu siapa ?")));
        assertTrue(nameResponseMock.contains(marine.getResponse("siapa kau ?")));
        assertTrue(nameResponseMock.contains(marine.getResponse("siapa dirimu ?")));

    }
}
