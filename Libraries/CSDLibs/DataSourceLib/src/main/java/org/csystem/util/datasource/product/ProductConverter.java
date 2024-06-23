package org.csystem.util.datasource.product;

import org.csystem.util.datasource.product.dto.ProductNameStockDTO;

public class ProductConverter {
    private final ProductInfo m_productInfo;

    //...
    public ProductConverter(ProductInfo productInfo)
    {
        m_productInfo = productInfo;
    }

    public ProductNameStockDTO toProductNameStockDTO()
    {
        return new ProductNameStockDTO(m_productInfo.getName(), m_productInfo.getStock());
    }
}
