/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author Hayk
 */
public class DoublyLinkedListTest {
    Iterable<String> listWith3Items;

    @Before
    public void before() {
        listWith3Items = createList(3);
    }

    private String createListItem(int i) {
        return "Het getal " + i;
    }
    
    private Iterable<String> createList(int size) {
        Iterable<String> list = new DoublyLinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(createListItem(i));
        }
        return list;
    }
    
    /**
     * INITIAL
     */
    @Test
    public void list_constructor_works_and_initializes_a_list_of_size_zero() {
        List emptyList = new DoublyLinkedList();
        assertEquals(0, emptyList.size());
    }

    @Test
    public void function_size_returns_3_for_a_list_containing_3_items() {
        assertEquals(3, listWith3Items.size());
    }

    @Test
    public void function_size_returns_1000_for_a_list_containing_1000_items() {
        int amount = 1000;
        List<String> listWith1000Items = createList(amount);
        assertEquals(amount, listWith1000Items.size());
    }

    @Test
    public void function_get_returns_correct_values_by_index() {
        for (int i = 0; i < listWith3Items.size(); i++) {
            assertEquals(createListItem(i), listWith3Items.get(i));
        }
    }

    /**
     * INDEXOF
     */
    @Test
    public void function_indexOf_returns_correct_index_for_each_item_within_a_list_containing_1000_items() {
        List<String> listWith1000Items = createList(1000);
        for (int i = 0; i < listWith1000Items.size(); i++) {
            assertEquals(i, listWith1000Items.indexOf(createListItem(i)));
        }
    }

    @Test
    public void function_indexOf_returns_correct_index_for_added_previous_and_next_items_after_adding_an_item() {
        List<String> listWith1000Items = createList(1000);
        String newValue = "Test 123";
        listWith1000Items.add(433, newValue);
        assertEquals(432, listWith1000Items.indexOf(createListItem(432)));
        assertEquals(433, listWith1000Items.indexOf(newValue));
        assertEquals(434, listWith1000Items.indexOf(createListItem(433)));
    }

    @Test
    public void function_indexOf_returns_minus_one_if_the_list_does_not_contain_the_corresponding_item() {
        assertEquals(-1, listWith3Items.indexOf("Value 123"));
    }

    /**
     * SET NEW VALUE
     */
    @Test
    public void function_size_still_returns_3_after_changing_item_value_using_function_set_within_a_list_containing_3_items() {
        String newValue = "Test 123";
        listWith3Items.set(1, newValue);
        assertEquals(3, listWith3Items.size());
    }

    @Test
    public void function_get_returns_correct_value_after_changing_an_item_value_using_function_set_within_a_list_containing_3_items() {
        String newValue = "Test 123";
        listWith3Items.set(1, newValue);
        assertEquals(newValue, listWith3Items.get(1));
    }

    /**
     * ADD NEW VALUE
     */
    @Test
    public void function_size_returns_4_after_adding_new_item_into_a_list_containing_3_items() {
        String newValue = "Test 123";
        listWith3Items.add(newValue);
        assertEquals(4, listWith3Items.size());
    }
    
    @Test
    public void function_get_returns_correct_value_after_adding_an_item_value_using_function_add_within_a_list_containing_3_items() {
        String newValue = "Test 123";
        listWith3Items.add(newValue);
        assertEquals(newValue, listWith3Items.get(3));
    }

    /**
     * ADD NEW VALUE AT INDEX
     */
    @Test
    public void function_size_returns_1_after_adding_an_item_into_a_new_list_at_index_zero() {
        List newList = new DoublyLinkedList();
        String newValue = "Test 123";
        newList.add(0, newValue);
        assertEquals(1, newList.size());
    }
    
    @Test
    public void function_get_returns_correct_value_after_adding_an_item_into_a_new_list_at_index_zero() {
        List newList = new DoublyLinkedList();
        String newValue = "Test 123";
        newList.add(0, newValue);
        assertEquals(newValue, newList.get(0));
    }
    
    @Test
    public void function_size_returns_4_after_adding_an_item_value_at_certain_index_into_a_list_containing_3_items_using_add_at_index() {
        String newValue = "Test 123";
        listWith3Items.add(1, newValue);
        assertEquals(4, listWith3Items.size());
    }

    @Test
    public void function_get_returns_correct_value_after_adding_an_item_value_at_certain_index_into_a_list_containing_3_items() {
        String newValue = "Test 123";
        listWith3Items.add(1, newValue);
        assertEquals(newValue, listWith3Items.get(1));
        assertEquals(createListItem(1), listWith3Items.get(2));
    }
    
    @Test
    public void function_size_returns_4_after_adding_an_item_value_at_first_index_into_a_list_containing_3_items_using_function_addFirst() {
        String newValue = "Test 123";
        listWith3Items.addFirst(newValue);
        assertEquals(4, listWith3Items.size());
    }
    
    @Test
    public void function_get_returns_correct_value_after_adding_an_item_value_at_first_index_into_a_list_containing_3_items_using_function_addFirst() {
        String newValue = "Test 123";
        listWith3Items.addFirst(newValue);
        assertEquals(newValue, listWith3Items.get(0));
    }
    
    @Test
    public void function_size_returns_4_after_adding_an_item_value_at_last_index_into_a_list_containing_3_items_using_function_addLast() {
        String newValue = "Test 123";
        listWith3Items.addLast(newValue);
        assertEquals(4, listWith3Items.size());
    }
    
    @Test
    public void function_get_returns_correct_value_after_adding_an_item_value_at_first_index_into_a_list_containing_3_items_using_function_addLast() {
        String newValue = "Test 123";
        listWith3Items.addLast(newValue);
        assertEquals(newValue, listWith3Items.get(3));
    }

    /**
     * REMOVE ITEM BY INDEX
     */
    @Test
    public void function_size_returns_2_after_removing_one_item_by_index_from_a_list_containing_3_items() {
        listWith3Items.remove(1);
        assertEquals(2, listWith3Items.size());
    }

    @Test
    public void function_get_returns_correct_value_after_removing_one_item_by_index_from_a_list_containing_3_items() {
        listWith3Items.remove(1);
        assertEquals(createListItem(0), listWith3Items.get(0));
        assertEquals(createListItem(2), listWith3Items.get(1));
    }
    
    @Test
    public void function_size_returns_2_after_removing_first_item_from_a_list_containing_3_items_using_function_removeFirst() {
        listWith3Items.removeFirst();
        assertEquals(2, listWith3Items.size());
    }
    
    @Test
    public void function_get_returns_correct_value_after_removing_first_item_from_a_list_containing_3_items_using_removeFirst() {
        listWith3Items.removeFirst();
        assertEquals(createListItem(1), listWith3Items.get(0));
        assertEquals(createListItem(2), listWith3Items.get(1));
    }
    
    @Test
    public void function_size_returns_2_after_removing_last_item_from_a_list_containing_3_items_using_function_removeLast() {
        listWith3Items.removeLast();
        assertEquals(2, listWith3Items.size());
    }
    
    @Test
    public void function_get_returns_correct_value_after_removing_last_item_from_a_list_containing_3_items_using_removeLast() {
        listWith3Items.removeLast();
        assertEquals(createListItem(0), listWith3Items.get(0));
        assertEquals(createListItem(1), listWith3Items.get(1));
    }

    /**
     * REMOVE ITEM BY VALUE
     */
    @Test
    public void function_size_returns_2_after_removing_an_item_by_value_from_a_list_containing_3_items() {
        listWith3Items.remove(createListItem(1));
        assertEquals(2, listWith3Items.size());
    }

    @Test
    public void function_get_returns_correct_value_after_removing_one_item_by_value_from_a_list_containing_3_items() {
        listWith3Items.remove(createListItem(1));
        assertEquals(createListItem(0), listWith3Items.get(0));
        assertEquals(createListItem(2), listWith3Items.get(1));
    }
    
    @Test
    public void function_size_still_returns_3_after_trying_to_remove_a_value_not_existing_in_a_list() {
        String notExistingValue = "Not Existing Value";
        listWith3Items.remove(notExistingValue);
        assertEquals(3, listWith3Items.size());
    }
    
    @Test
    public void function_get_returns_3_correct_items_after_trying_to_remove_a_value_not_existing_in_a_list() {
        String notExistingValue = "Not Existing Value";
        listWith3Items.remove(notExistingValue);
        for (int i = 0; i < listWith3Items.size(); i++) {
            assertEquals(createListItem(i), listWith3Items.get(i));
        }
    }
    
    @Test
    public void function_remove_returns_true_after_removing_a_value_existing_in_a_list() {
        String existingValue = createListItem(1);
        assertTrue(listWith3Items.remove(existingValue));
    }
    
    @Test
    public void function_remove_returns_false_after_trying_to_remove_a_value__not_existing_in_a_list() {
        String notExistingValue = "Not Existing Value";
        assertFalse(listWith3Items.remove(notExistingValue));
    }
    
    /**
     * REMOVE ALL ITEMS BY VALUE
     */
    @Test
    public void function_size_returns_95_after_removing_all_5_items_having_same_value_from_a_list_containing_100_values_using_function_removeAll() {
        int amount = 100;
        List<String> listWith100Items = createList(amount);

        String newValue = "Test 123";
        listWith100Items.set(0, newValue);
        listWith100Items.set(5, newValue);
        listWith100Items.set(16, newValue);
        listWith100Items.set(63, newValue);
        listWith100Items.set(99, newValue);

        listWith100Items.removeAll(newValue);

        assertEquals(95, listWith100Items.size());
    }
    
    @Test
    public void function_size_returns_100_after_adding_then_removing_same_items_from_a_list_containing_100_values_using_function_removeAll() {
        int amount = 100;
        List<String> listWith100Items = createList(amount);

        String newValue = "Test 123";
        listWith100Items.add(0, newValue);
        listWith100Items.add(5, newValue);
        listWith100Items.add(16, newValue);
        listWith100Items.add(100, newValue);
        listWith100Items.add(102, newValue);

        listWith100Items.removeAll(newValue);

        assertEquals(100, listWith100Items.size());
    }
    
    @Test
    public void function_get_returns_100_correct_values_after_adding_then_removing_same_items_from_a_list_containing_100_values_using_function_removeAll() {
        int amount = 100;
        List<String> listWith100Items = createList(amount);

        String newValue = "Test 123";
        listWith100Items.add(0, newValue);
        listWith100Items.add(5, newValue);
        listWith100Items.add(16, newValue);
        listWith100Items.add(100, newValue);
        listWith100Items.add(102, newValue);

        listWith100Items.removeAll(newValue);

        for (int i = 0; i < listWith100Items.size(); i++) {
            assertEquals(createListItem(i), listWith100Items.get(i));
        }
    }
    
    @Test
    public void function_size_still_returns_3_after_trying_to_remove_a_value_not_existing_in_a_list_using_function_removeAll() {
        String notExistingValue = "Not Existing Value";
        listWith3Items.removeAll(notExistingValue);
        assertEquals(3, listWith3Items.size());
    }
    
    @Test
    public void function_get_returns_3_correct_items_after_trying_to_remove_a_value_not_existing_in_a_list_using_function_removeAll() {
        String notExistingValue = "Not Existing Value";
        listWith3Items.removeAll(notExistingValue);
        for (int i = 0; i < listWith3Items.size(); i++) {
            assertEquals(createListItem(i), listWith3Items.get(i));
        }
    }
    
    @Test
    public void function_removeAll_returns_true_after_removing_values_existing_in_a_list() {
        String existingValue = "Test 123";
        listWith3Items.add(existingValue);
        listWith3Items.add(0, existingValue);
        listWith3Items.set(1, existingValue);
        assertTrue(listWith3Items.removeAll(existingValue));
    }
    
    @Test
    public void function_removeAll_returns_false_after_trying_to_remove_a_value__not_existing_in_a_list() {
        String notExistingValue = "Not Existing Value";
        assertFalse(listWith3Items.removeAll(notExistingValue));
    }
    
    /**
     * CLEAR
     */
    
    @Test
    public void function_size_returns_0_after_making_a_list_containing_3_items_empty_using_function_clear() {
        listWith3Items.clear();
        assertEquals(0, listWith3Items.size());
    }
    
    /**
     * INDEX OUT OF BOUND EXCEPTION
     */
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void function_get_throws_IndexOutOfBoundsException_if_item_index_is_not_valid() {
        listWith3Items.get(-1);
        listWith3Items.get(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void function_set_throws_IndexOutOfBoundsException_if_item_index_is_not_valid() {
        String newValue = "Test 123";
        listWith3Items.set(-1, newValue);
        listWith3Items.set(3, newValue);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void function_add_throws_IndexOutOfBoundsException_if_item_index_is_not_valid() {
        String newValue = "Test 123";
        listWith3Items.add(-1, newValue);
        listWith3Items.add(4, newValue);
    }
    
    /**
     * STRING VERSIONS OF LIST
     */
    @Test
    public void forwardStringVersionOfList_returns_empty_string_for_a_empty_list() {
        Iterable list = new DoublyLinkedList();
        assertEquals("", list.forwardStringVersionOfList());
    }
    
    @Test
    public void forwardStringVersionOfList_returns_correctValue_of_a_list_containing_1_item() {
        String value = "Test 123";
        Iterable list = new DoublyLinkedList();
        list.add(value);
        assertEquals(value, list.forwardStringVersionOfList());
    }
    
    @Test
    public void forwardStringVersionOfList_returns_correctValue_of_a_list_containing_3_items() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listWith3Items.size() - 1; i++) {
            sb.append(listWith3Items.get(i)).append("\n");
        }
        sb.append(listWith3Items.get(listWith3Items.size() - 1));
        assertEquals(sb.toString(), listWith3Items.forwardStringVersionOfList());
    }
    
    @Test
    public void backwardStringVersionOfList_returns_empty_string_for_a_empty_list() {
        Iterable list = new DoublyLinkedList();
        assertEquals("", list.backwardStringVersionOfList());
    }
    
    @Test
    public void backwardStringVersionOfList_returns_correctValue_of_a_list_containing_1_item() {
        String value = "Test 123";
        Iterable list = new DoublyLinkedList();
        list.add(value);
        assertEquals(value, list.backwardStringVersionOfList());
    }
    
    @Test
    public void backwardStringVersionOfList_returns_correctValue_of_a_list_containing_3_items() {
        StringBuilder sb = new StringBuilder();
        for (int i = listWith3Items.size() - 1; i >= 1; i--) {
            sb.append(listWith3Items.get(i)).append("\n");
        }
        sb.append(listWith3Items.get(0));
        assertEquals(sb.toString(), listWith3Items.backwardStringVersionOfList());
    }
}
