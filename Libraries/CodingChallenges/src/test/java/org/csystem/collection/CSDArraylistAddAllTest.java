 package org.csystem.collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

 @RunWith(Parameterized.class)
 public class CSDArraylistAddAllTest {
     public static class DataInfo {
         CSDArrayList<Integer> element;
         ArrayList<Integer> list;
         int listSize, elementSize;

         DataInfo(int listSize, int elementSize) {
             this.listSize = listSize;
             this.elementSize = elementSize;

             list =  new ArrayList<>();
             for (var i = 0; i < listSize; ++i)
                 list.add(i * 3);

             element = new CSDArrayList<>();
             for (var i = 0; i < elementSize; ++i)
                 element.add(i * 2);

             element.addAll(list);
         }
     }
     DataInfo data;
     CSDArraylistAddAllTest(DataInfo data) {
         this.data = data;
     }
     @Parameterized.Parameters
     public static Collection<DataInfo> createData()
     {
         return List.of(new DataInfo(15, 20),
                 new DataInfo(5,  15),
                 new DataInfo(0, 0)
         );
     }
     @Test
     public void test()
     {
         Assert.assertEquals(data.listSize + data.elementSize, data.element.size());
     }
 }
