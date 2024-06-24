// Açıklamalar:
// - StringMap<T> sınıfının public bölümünü değiştirmeden istediğiniz eklemeyi yapabilirsiniz
//
// - IStringMap<T> arayüzünde bir değişiklik yapılmayacaktır. Bu arayüz anahtarı string olan bir map collection
//   sınıfları için implemente edilebilecektir.
//
// - IStringMap<T> arayüzünün abstract metotları şu şekildedir:
// - count: "String map" içerisindeki anahtar eleman sayısına geri dönecektir.
//
//  - addElement: Metot parametresi ile aldığı anahtar ve değeri ekleyecektir. Eğer anahtar daha önce varsa
//  true, yoksa false değerine geri dönecektir. Anahtar değerinin null olması veya blank string olması durumunda
//  IllegalArgumentException fırlatacaktır.
//
//  - removeElement: Metot parametresi aldığı anahtar varsa ve silebilirse true, aksi durumda false değerine
//  geri dönecektir. Anahtar değerinin null veya blank string olması durumunda IllegalArgumentException
//  fırlatacaktır.
//
//  - getValue(String key): Metot parametresi ile aldığı anahtara karşılık gelen değeri Optional olarak geri
//  dönecektir. Anahtar değerinin null olması veya blank string olması durumunda IllegalArgumentException
//  fırlatacaktır.
//
//  - getValue(String key, T defaultValue): Metot parametresi ile aldığı anahtara karşılık gelen değeri
//  döndrürecektir. Anahtar yoksa ikinci parametresi ile aldığı değere geri dönecektir. Anahtar değerinin
//  null olması veya blank string olması durumunda IllegalArgumentException fırlatacaktır.

package org.csystem.collection;

import java.util.Optional;

public class StringMap<T> implements IStringMap<T> {
    @Override
    public int count()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public boolean addElement(String key, T value)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public boolean removeElement(String key)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public Optional<T> getValue(String key)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public T getValue(String key, T defaultValue)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }
}