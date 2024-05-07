/*-------------------------------------------------------------
	FILE		: Triangle.java
	AUTHOR		: JavaApp1-Nov-2023 Group
	Last UPDATE	: 7th May 2024

	Triangle class that represents a triangle

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.math.geometry;

public class Triangle {
    private double m_a, m_b, m_c;
    public Triangle(double a)
    {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Creates a triangle object by checking validity  with the conditions
     * a + b > c AND a + c > b AND b + c > a AND abs(a - b) < c AND abs(a - c) < b AND abs(b - c) < a  
     * @throws IllegalArgumentException if the triangle is not valid
     * @param b
     * @param c
     */
    public Triangle(double a, double b, double c)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public double getA()
    {
        throw new UnsupportedOperationException("TODO");
     }

    public double getB()
    {
        throw new UnsupportedOperationException("TODO");
    }

    public double getC()
    {
        throw new UnsupportedOperationException("TODO");
    }

    public void setA(double a)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public void setB(double b)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public void setC(double c)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public double getCircumference()
    {
        throw new UnsupportedOperationException("TODO");
    }
    /**
     * If u is half of circumference area is calculated by the formula sqrt(u * (u - a) * (u - b) * (u - c))
     * @return area of the triangle
     */
    public double getArea()
    {
        throw new UnsupportedOperationException("u half of circumference");
    }

    /**
     * That is calculated via area = a * ha / 2
     * @return height belongs to a side
     */
    public double getHeightOfA()
    {
        throw new UnsupportedOperationException("TODO");
    }
    /**
     * That is calculated via area = b * hb / 2
     * @return height belongs to b side
     */
    public double getHeightOfB()
    {
        throw new UnsupportedOperationException("TODO");
    }
    /**
     * That is calculated via area = c * hc / 2
     * @return height belongs to c  side
     */
    public double getHeightOfC()
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean equals(Object obj)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int hashCode()
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}