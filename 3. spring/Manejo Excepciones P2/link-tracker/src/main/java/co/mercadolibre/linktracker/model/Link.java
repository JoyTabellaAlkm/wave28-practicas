package co.mercadolibre.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private int linkID;
    private String url;
    private String password;

    private int redirectionCounter;
}
