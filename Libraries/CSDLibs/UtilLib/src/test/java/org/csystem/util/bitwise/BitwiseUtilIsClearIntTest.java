 package org.csystem.util.bitwise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

 @RunWith(Parameterized.class)
 public class BitwiseUtilIsClearIntTest {
     static class DataInfo {
         int val;
         int n;
         public DataInfo(int val, int n) {
             this.val = val;
             this.n = n;
         }
     }
     public BitwiseUtilIsClearIntTest(DataInfo dataInfo) {
         this.dataInfo = dataInfo;
     }
 
     public DataInfo dataInfo;
     @Parameterized.Parameters
     public static Collection<DataInfo> createData()
     {
         return List.of(new DataInfo(0x51, 1),
                 new DataInfo(0x41, 4));
     }
     @Test
     public void test()
     {
         Assert.assertTrue(BitwiseUtil.isClear(dataInfo.val, dataInfo.n));
     }
 }
