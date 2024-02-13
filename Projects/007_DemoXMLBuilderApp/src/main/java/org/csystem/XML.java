package org.csystem;

class XML {
    private String m_tag;
    private String m_value;
    private String m_attribute;
    private String m_attrValue;
    public static class Builder {
        private final XML m_xml;
        public Builder()
        {
            m_xml = new XML("","","","");
        }
        public Builder setTag(String tag)
        {
            m_xml.m_tag = tag;
            return this;
        }

        public Builder setValue(String value)
        {
            m_xml.m_value = value;
            return this;
        }

        public Builder setAttribute(String attribute)
        {
            m_xml.m_attribute = attribute;
            return this;
        }

        public Builder setAttributeValue(String attrValue)
        {
            m_xml.m_attrValue = attrValue;
            return this;
        }

        public XML build()
        {
            return m_xml;
        }

    }
    private XML(String tag, String value, String attribute, String attrValue)
    {
        m_tag = tag;
        m_value = value;
        m_attribute = attribute;
        m_attrValue = attrValue;
    }
    public String getTag()
    {
        return m_tag;
    }
    public String getValue()
    {
        return m_value;
    }
    public String getAttribute()
    {
        return m_attribute;
    }
    public String getAttrValue()
    {
        return m_attrValue;
    }
    public String toString()
    {
        var sb = new StringBuilder();

        sb.append("<")
                .append(m_tag)
                .append(!m_attribute.isEmpty() ? " " + m_attribute + "=" + (m_attrValue.isEmpty() ? "\"\"" : '"' + m_attrValue + '"'): "")
                .append(">")
                .append(m_value)
                .append("</").append(m_tag).append(">");

        return sb.toString();
    }
}
