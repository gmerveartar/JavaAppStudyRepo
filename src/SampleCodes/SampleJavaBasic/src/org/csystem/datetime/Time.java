/*----------------------------------------------------------------------------------------------------------------------
    Aşağıda bildirilen Date sınıfını açıklamalara göre yazınız
    Açıklamalar:
        - Sınıf bir zamanı temsil edecektir (saat, dakika, saniye, mili saniye)

        - JavaSE'nin veya başka bir kütüphanenin tarih zaman işlemlerine ilişkin sınıfları ve metotları kullanılmayacaktır

        - Sınıfın public bölümünü değiştirmeden istediğiniz eklemeyi yapabilirsiniz

        - Sınıf geçersiz zaman durumunu kontrol edecektir. Geçersizlik durumunda exception fırlatılacaktır

        - Zamana ilişkin sınırlar şu şekildedir:
            saat        -> [0, 23]
            dakika      -> [0, 59]
            saniye      -> [0, 59]
            mili saniye -> [0, 999]

        - Sınıfa ilişkin test kodlarını da yazınız

        - Sınıfın public metotlarındaki
	            throw new UnsupportedOperationException("TODO:");
        deyimini silerek ilgili metodu yazabilirsiniz. Bu deyim bazı error durumlarını engellemek için eklenmiştir. Şu an
        bu deyime odaklanmanız gerekmez
-----------------------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------------------
	FILE		: Time.java
	AUTHOR		: Java-Mar-2023 Group
	LAST UPDATE	: 24th Sep 2023

	Time class that represents a time

	Copyleft (c) 1993 by C and System Programmers Association
	All Rights Free
------------------------------------------------------------------ */
package org.csystem.datetime;

public class Time {
    public Time(int hour, int minute)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public Time(int hour, int minute, int second)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public Time(int hour, int minute, int second, int millisecond)
    {
        throw new UnsupportedOperationException("TODO:");
    }



    public int getHour()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public void setHour(int value)
    {
        throw new UnsupportedOperationException("TODO:");
    }


    public int getMinute()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public void setMinute(int value)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public int getSecond()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public void setSecond(int value)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public int getMillisecond()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public void setMillisecond(int value)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public String toString()
    {
        throw new UnsupportedOperationException("TODO -> 17:01:08");
    }


    public String toLongTimeStringTR()
    {
        throw new UnsupportedOperationException("TODO -> 17:01:08.123");
    }

    public String toShortTimeStringTR()
    {
        throw new UnsupportedOperationException("TODO -> 17:01");
    }
}
