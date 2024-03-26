/*-------------------------------------------------------------
	FILE		: MutablePoint.java
	AUTHOR		: JavaApp1-Nov-2023 Group
	Last UPDATE	: 17th Mar 2024

	MutablePoint class that represents a point in cartesian
	plane

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.math.geometry;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public final class MutablePoint {
    private double m_x;
    private double m_y;

    MutablePoint(double x, double y)
    {
        m_x = x;
        m_y = y;
    }

    private MutablePoint(double a, double b, boolean polar)
    {
        if (polar) {
            m_x = a * cos(b);
            m_y = a * sin(b);
        }
        else {
            m_x = a;
            m_y = b;
        }
    }

    public static MutablePoint createCartesian(double x, double y)
    {
        return new MutablePoint(x, y, false);
    }

    public static MutablePoint createPolar(double radius, double theta)
    {
        return new MutablePoint(radius, theta, true);
    }

    public void setX(double x)
    {
        m_x = x;
    }
    public double getX()
    {
        return m_x;
    }
    public double getY()
    {
        return m_y;
    }

    public void setY(double y)
    {
        m_y = y;
    }

    public double distance()
    {
        return distance(0, 0);
    }

    public double distance(MutablePoint other)
    {
        return distance(other.m_x, other.m_y);
    }

    public double distance(double x, double y)
    {
        return PointCommon.distance(m_x, m_y, x, y);
    }

    public void offset(double dxy)
    {
        offset(dxy, dxy);
    }

    public void offset(double dx, double dy)
    {
        m_x += dx;
        m_y += dy;
    }

    public Point toPoint()
    {
        return new Point(m_x, m_y);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof MutablePoint p && PointCommon.equals(m_x, m_y, p.m_x, p.m_y);
    }

    @Override
    public String toString()
    {
        return PointCommon.toString(m_x, m_y);
    }
}