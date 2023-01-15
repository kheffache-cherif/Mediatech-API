package org.cherif.mediatheque.shared;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE) // ACCICIBILITE  POUR NR PAS SPECIFIER ATTRIBUT PRIVATE
@Builder

public class ErrorMessage {


    String message;
    Date timstamp;
    Integer code;
}
