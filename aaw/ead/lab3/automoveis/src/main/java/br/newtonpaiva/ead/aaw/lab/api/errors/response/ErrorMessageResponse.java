package br.newtonpaiva.ead.aaw.lab.api.errors.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@AllArgsConstructor
@NoArgsConstructor
@With
public class ErrorMessageResponse {

	  private Integer code;
	  
	  private List<ErrorMessage> messages;

}
