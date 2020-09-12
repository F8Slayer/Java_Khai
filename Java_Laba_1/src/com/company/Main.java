package com.company;

/**
 * This is my first work with Java
 * @author Linnik Alex
 * @version 0.1
 * @since 01.09.2020
 */

public class Main {
    /**
     * This method will show essential info about the student
     * @param args Unsued.
     * @return Nothing.
     */
    public static void main(String[] args) {
	    System.out.println("Group: 535st1");
	    System.out.println("Student: Linnik Alexandr Anatolevich");
	    System.out.println("Variant: 15");
	    String [] array = {
	            "**                           **                       **         \n",
                "**                          ****                     ****        \n",
                "**                         **  **                   **  **       \n",
                "**                        **    **                 **    **      \n",
                "**                       **      **               **      **     \n",
                "**                      ************             ************    \n",
                "**                     **          **           **          **   \n",
                "**                    **            **         **            **  \n",
                "***************      **              **       **              ** \n",
                "***************     **                **     **                **\n"
        };
        for (int i=0; i< array.length; i++){
            System.out.print(array[i]);
        }
    }
}
