 package org.csystem.util.bitwise;

import  org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

 @RunWith(Parameterized.class)
 public class BitwiseUtilIndicesOfSetBitsIntTest {
     static class DataInfo {
         int val;
         int [] expected;
         public DataInfo(int val, int[] expected) {
             this.val = val;
             this.expected = expected;
         }
     }
     public BitwiseUtilIndicesOfSetBitsIntTest(DataInfo dataInfo) {
         this.dataInfo = dataInfo;
     }
 
     public DataInfo dataInfo;
     @Parameterized.Parameters
     public static Collection<DataInfo> createData()
     {
         return List.of(new DataInfo(10, new int [] {1, 3}),
                 new DataInfo(0, new int [0 ]));
     }
     @Test
     public void test()
     {
         Assert.assertArrayEquals(dataInfo.expected, BitwiseUtil.indicesOfSetBits(dataInfo.val));
     }
 }
