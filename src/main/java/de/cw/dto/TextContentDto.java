package de.cw.dto;

import lombok.Data;

@Data
public class TextContentDto {

    private PrimaryTextDto primaryText = new PrimaryTextDto();

    private SecondaryTextDto secondaryText = new SecondaryTextDto();

    private TertiaryTextDto tertiaryText = new TertiaryTextDto();

}