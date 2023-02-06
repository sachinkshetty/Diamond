package com.app.test;

import com.app.test.AlphabetException;
import com.app.test.Diamond;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiamondTest {

    public Diamond diamondCutter;

    @BeforeEach
    public void setUp() {
	diamondCutter = new Diamond();
    }

    @Test
    public void test_should_print_single_row_for_one_character() {
	List<String> diamonds = diamondCutter.printDiamonds('A');
	Assertions.assertEquals(diamonds.get(0),"A");
    }

    @Test
    public void test_should_print_space_on_each_side_of_first_line_for_B() {
	List<String> diamonds = diamondCutter.printDiamonds('B');
	Assertions.assertEquals(diamonds.get(0),"-A-");
    }

    @Test
    public void test_should_print_two_space_on_each_side_of_first_line_for_C() {
	List<String> diamonds = diamondCutter.printDiamonds('C');
	Assertions.assertEquals(diamonds.get(0),"--A--");
    }

    @Test
    public void test_should_print_B_in_second_row() {
	List<String> diamonds = diamondCutter.printDiamonds('B');
	Assertions.assertEquals(diamonds.get(1),"B-B");
    }

    @Test
    public void test_should_print_C_in_third_row() {
	List<String> diamonds = diamondCutter.printDiamonds('C');
	Assertions.assertEquals(diamonds.get(2), "C---C");
    }

    @Test
    public void test_should_print_second_row_for_middle_letter_is_C() {
	List<String> diamonds = diamondCutter.printDiamonds('C');
	Assertions.assertEquals(diamonds.get(1),"-B-B-");
    }

    @Test
    public void test_should_print_second_row_for_middle_letter_is_D() {
	List<String> diamonds = diamondCutter.printDiamonds('D');
	Assertions.assertEquals(diamonds.get(1),"--B-B--");
    }

    @Test
    public void test_should_print_third_row_for_middle_letter_is_D() {
	List<String> diamonds = diamondCutter.printDiamonds('D');
	Assertions.assertEquals(diamonds.get(2),"-C---C-");
    }

    @Test
    public void test_should_print_all_rows_for_middle_letter_is_D() {
	List<String> diamonds = diamondCutter.printDiamonds('D');
	Assertions.assertEquals(diamonds.get(0),"---A---");
	Assertions.assertEquals(diamonds.get(1),"--B-B--");
	Assertions.assertEquals(diamonds.get(2),"-C---C-");
	Assertions.assertEquals(diamonds.get(3),"D-----D");
    }

    @Test
    public void test_should_print_complete_diamond_for_middle_letter_is_D() {
	List<String> diamonds = diamondCutter.printDiamonds('D');
	Assertions.assertEquals(diamonds.get(0),"---A---");
	Assertions.assertEquals(diamonds.get(1),"--B-B--");
	Assertions.assertEquals(diamonds.get(2),"-C---C-");
	Assertions.assertEquals(diamonds.get(3),"D-----D");
	Assertions.assertEquals(diamonds.get(4),"-C---C-");
	Assertions.assertEquals(diamonds.get(5),"--B-B--");
	Assertions.assertEquals(diamonds.get(6),"---A---");
    }

    @Test
    public void test_should_print_complete_diamond_in_upper_case_for_middle_letter_is_d() {
	List<String> diamonds = diamondCutter.printDiamonds('d');
	Assertions.assertEquals(diamonds.get(0),"---A---");
	Assertions.assertEquals(diamonds.get(1),"--B-B--");
	Assertions.assertEquals(diamonds.get(2),"-C---C-");
	Assertions.assertEquals(diamonds.get(3),"D-----D");
	Assertions.assertEquals(diamonds.get(4),"-C---C-");
	Assertions.assertEquals(diamonds.get(5),"--B-B--");
	Assertions.assertEquals(diamonds.get(6),"---A---");
    }

    @Test
    public void test_should_throw_exception_for_middle_letter_not_being_alphabet() {
	final Throwable exceptionThatWasThrown = assertThrows(AlphabetException.class, () -> {
	    diamondCutter.printDiamonds('1');
	});

	Assertions.assertEquals("middle letter passed is not an alphabet : 1",
	    exceptionThatWasThrown.getMessage());
    }
}

