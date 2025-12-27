package com.ecommerce.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemsDTO {

    private Long cartItemId;
    private CartDTO cart;
    private ProductDTO productDto;
    private Integer quantity;
    private Double discount;
    private Double productPrice;

}
