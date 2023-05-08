package com.hczq.verctrl;

/**
 * @Description
 * @Author hejinkang
 * @Date 2023/5/8 11:13
 * @Version 1.0
 */
public class StringVerComparator implements VerComparator {





    @Override
    public int versionCompare(String ver1, String ver2) {
        String[] arr1 = ver1.split("\\.");
        String[] arr2 = ver2.split("\\.");
        int i = 0;
        while (i < arr1.length && i < arr2.length && arr1[i].equals(arr2[i])) {
            i++;
        }
        while (i < arr1.length && Integer.parseInt(arr1[i]) == 0) {
            i++;
        }
        while (i < arr2.length && Integer.parseInt(arr2[i]) == 0) {
            i++;
        }
        if (i == arr1.length && i == arr2.length) {
            return 0;
        }
        if (i == arr1.length) {
            return -1;
        }
        if (i == arr2.length) {
            return 1;
        }
        int diff = Integer.parseInt(arr1[i]) - Integer.parseInt(arr2[i]);
        return Integer.signum(diff);
    }


}
