package trangchuadmin.donghohanquoc.Model.Input;


import lombok.Data;
import trangchuadmin.donghohanquoc.Model.Entity.BrandEntity;

import java.util.List;

@Data
public class ProductInput {
    private String productname;
    private String image;
    private Integer price;
    private String description;
    private BrandEntity brandentity;
    private Integer quantitysold;
    private Integer quantityremaining;
    private String createdby;
    private List<ProductAtributeInput> productAtributeInputList;
    private List<ProductCategoriesInput> productCategoriesInputList;
}
