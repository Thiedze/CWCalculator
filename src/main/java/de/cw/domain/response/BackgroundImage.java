package de.cw.domain.response;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.Getter;

@Data
public class BackgroundImage {

    @Getter
    private List<Source> sources;

    public BackgroundImage() {
        this.sources = new ArrayList<>();
    }

}
