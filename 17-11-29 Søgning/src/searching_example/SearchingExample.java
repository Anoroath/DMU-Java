package searching_example;

import java.util.ArrayList;

public class SearchingExample {
    public static int linearSearchList(ArrayList<String> list, String target) {
        boolean found = false;
        int i = 0;
        while (!found && i < list.size()) {
            if (list.get(i).equals(target)) {
                found = true;
            } else {
                i++;
            }
        }
        if (found)
            return i;
        else
            return -1;
    }


    public static Customer linearSearchCustomer(ArrayList<Customer> list, String name) {
        boolean found = false;
        int i = 0;
        Customer kunde = null;
        while(!found && i < list.size()){
            kunde = list.get(i);
            if (kunde.getName().equals(name)) {
                found = true;
            } else {
                i++;
            }
        }
        if (found)
            return kunde;
        else
            return null;
    }

    public static int linearSearchArray(String[] list, String target) {
        boolean found = false;
        int i = 0;
        while(!found && i < list.length){
            if (list[i].equals(target)) {
                found = true;
            } else {
                i++;	
            }
        }
        if (found)
            return i;
        else
            return -1;
    }

    public static Customer linearSearchCustomerArray(Customer[] list, String name) {
        boolean found = false;
        int i = 0;
        Customer kunde = null;
        while(!found && i < list.length) {
            kunde = list[i];
            if (kunde.getName().equals(name)) {
                found = true;
            } else {
                i++;    
            }	
        }
        if (found)
            return kunde;
        else
            return null;
    }

    public static int binSearchArray(int[] arr, int target) {
        boolean found = false;
        int left = 0;
        int right = arr.length - 1;
        int middle = -1;
        while (!found && left <= right) {
            middle = (left + right) / 2;
            int k = arr[middle];
            if (k == target)
                found = true;
            else if(k > target)
                right = middle-1;
            else left = middle+1;
        }
        if (found)
            return middle;
        else
            return -1;
    }

    public static Customer binSearchList(ArrayList<Customer> list, String name) {
        boolean found = false;
        int left = 0;
        int right = list.size() - 1;
        int middle = -1;
        Customer kunde = null;
        while (!found && left <= right) {
            middle = (left+right) / 2;
            kunde = list.get(middle);
            int comp = kunde.getName().compareTo(name);
            if (comp == 0)
                found = true;
            else if(comp > 0)
                right = middle - 1;
            else left = middle + 1;
        }
        if (found)
            return kunde;
        else
            return null;
    }

}
