package com.giotuhoclaptrinh.mapper;

import com.giotuhoclaptrinh.dto.NewProductDTO;
import com.giotuhoclaptrinh.entity.ProductEntity;
import java.util.Arrays;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-07T15:41:07+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class IProductMapperImpl implements IProductMapper {

    @Override
    public ProductEntity toEntity(NewProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setCreatedBy( dto.getCreatedBy() );
        productEntity.setCreatedDate( dto.getCreatedDate() );
        productEntity.setModifiedBy( dto.getModifiedBy() );
        productEntity.setModifiedDate( dto.getModifiedDate() );
        productEntity.setCode( dto.getCode() );
        String[] image = dto.getImage();
        if ( image != null ) {
            productEntity.setImage( Arrays.copyOf( image, image.length ) );
        }
        productEntity.setImg( dto.getImg() );
        productEntity.setNameProduct( dto.getNameProduct() );
        productEntity.setOldPrice( dto.getOldPrice() );
        productEntity.setOriginalPrice( dto.getOriginalPrice() );
        productEntity.setQuantity( dto.getQuantity() );
        productEntity.setSale( dto.getSale() );
        String[] size = dto.getSize();
        if ( size != null ) {
            productEntity.setSize( Arrays.copyOf( size, size.length ) );
        }
        productEntity.setStatus( dto.getStatus() );

        return productEntity;
    }

    @Override
    public ProductEntity toEntity(NewProductDTO dto, ProductEntity entity) {
        if ( dto == null ) {
            return entity;
        }

        entity.setCreatedBy( dto.getCreatedBy() );
        entity.setCreatedDate( dto.getCreatedDate() );
        entity.setModifiedBy( dto.getModifiedBy() );
        entity.setModifiedDate( dto.getModifiedDate() );
        entity.setCode( dto.getCode() );
        String[] image = dto.getImage();
        if ( image != null ) {
            entity.setImage( Arrays.copyOf( image, image.length ) );
        }
        else {
            entity.setImage( null );
        }
        entity.setImg( dto.getImg() );
        entity.setNameProduct( dto.getNameProduct() );
        entity.setOldPrice( dto.getOldPrice() );
        entity.setOriginalPrice( dto.getOriginalPrice() );
        entity.setQuantity( dto.getQuantity() );
        entity.setSale( dto.getSale() );
        String[] size = dto.getSize();
        if ( size != null ) {
            entity.setSize( Arrays.copyOf( size, size.length ) );
        }
        else {
            entity.setSize( null );
        }
        entity.setStatus( dto.getStatus() );

        return entity;
    }

    @Override
    public NewProductDTO toDTO(ProductEntity entity) {
        if ( entity == null ) {
            return null;
        }

        NewProductDTO.NewProductDTOBuilder newProductDTO = NewProductDTO.builder();

        newProductDTO.code( entity.getCode() );
        newProductDTO.img( entity.getImg() );
        String[] image = entity.getImage();
        if ( image != null ) {
            newProductDTO.image( Arrays.copyOf( image, image.length ) );
        }
        newProductDTO.nameProduct( entity.getNameProduct() );
        newProductDTO.oldPrice( entity.getOldPrice() );
        newProductDTO.originalPrice( entity.getOriginalPrice() );
        newProductDTO.quantity( entity.getQuantity() );
        newProductDTO.sale( entity.getSale() );
        String[] size = entity.getSize();
        if ( size != null ) {
            newProductDTO.size( Arrays.copyOf( size, size.length ) );
        }
        newProductDTO.status( entity.getStatus() );

        return newProductDTO.build();
    }
}
