package com.giotuhoclaptrinh.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
public class NewProductDTO extends AbstractDTO<NewProductDTO>{
	 String code;
	 String img;
	 String[] image;
	 String nameProduct;
	 Long oldPrice;
	 Long originalPrice;
	 Long quantity;
	 String sale;
	 String[] size;
	 String status;
	 String categoryCode;
}
