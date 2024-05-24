package org.csystem.util.collection;

import org.csystem.util.string.StringUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Disabled ("Tested before and passed")
public class CollectionUtilToModifiableSetTest {
    private Stream <String> m_stream;

    @BeforeEach
    public void setUp()
    {
        var random = new Random();
        m_stream = Stream.generate(() -> StringUtil.generateRandomTextEN(random, 10))
                .limit(10);
    }

    @Test
    public void givenStream_thenReturnsModifiableListDoesNotThrowsException()
    {
        var modifiableSet = CollectionUtil.toModifiableSet(m_stream);
        Assertions.assertDoesNotThrow(() -> modifiableSet.add("CSD"));
    }
    @Test
    public void givenList_whenUnmodifiable_thenReturnsModifiableListDoesNotThrowsException()
    {
        var modifiableSet = CollectionUtil.toModifiableSet(m_stream.collect(Collectors.toSet()));
        Assertions.assertDoesNotThrow(() -> modifiableSet.add("CSD"));
    }
}
