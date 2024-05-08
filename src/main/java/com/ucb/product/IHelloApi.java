// package com.ucb.product;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;

// import com.ucb.product.dto.ErrorResponse;
// import com.ucb.product.dto.ProductDto;
// import com.ucb.product.dto.login;
// import com.ucb.product.dto.tarjeta;

// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.media.Content;
// import io.swagger.v3.oas.annotations.media.Schema;
// import io.swagger.v3.oas.annotations.responses.ApiResponse;
// import io.swagger.v3.oas.annotations.responses.ApiResponses;
// import io.swagger.v3.oas.annotations.tags.Tag;

// public interface IHelloApi {

//     @Tag(name = "Products", description = "Obtain the list of products")
//     @Operation(summary = "Lista de productos", description = "Loren ipsum")
//     @ApiResponses(
//         value = {
//             @ApiResponse(
//                 responseCode = "200", description = "loren ipson landa bla"
//             ),
//             @ApiResponse(
//                 responseCode = "500", description = "${api.responseCodes.internalServer.description}",
//                  content = {
//                     @Content(mediaType = "application/json",
//                              schema = @Schema(implementation = ErrorResponse.class))
//                  }

//             )
//         }
//     )
//     public String index();
    
//     @Tag(name = "Products", description = "Obtain one product by id")
//     public ResponseEntity<ProductDto> obtain(String id);


//     @Tag(name = "Products", description = "Create product")
//     public ResponseEntity<ProductDto> create(ProductDto product);

// }
package com.ucb.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.ucb.product.dto.ErrorResponse;
import com.ucb.product.dto.Login;
import com.ucb.product.dto.tarjeta;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

public interface IHelloApi {

    @Tag(name = "Authentication", description = "User login")
    @Operation(summary = "User login", description = "Endpoint to authenticate user")
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200", description = "Successful login",
                content = {
                    @Content(mediaType = "text/plain",
                             schema = @Schema(implementation = String.class))
                }
            ),
            @ApiResponse(
                responseCode = "500", description = "${api.responseCodes.internalServer.description}",
                 content = {
                    @Content(mediaType = "application/json",
                             schema = @Schema(implementation = ErrorResponse.class))
                 }

            )
        }
    )
    @PostMapping("/login")
    public ResponseEntity<String> login(Login login);

    @Tag(name = "Payment", description = "Process credit card payment")
    @Operation(summary = "Process credit card payment", description = "Endpoint to process credit card payment")
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200", description = "Payment processed successfully",
                content = {
                    @Content(mediaType = "text/plain",
                             schema = @Schema(implementation = String.class))
                }
            ),
            @ApiResponse(
                responseCode = "500", description = "${api.responseCodes.internalServer.description}",
                 content = {
                    @Content(mediaType = "application/json",
                             schema = @Schema(implementation = ErrorResponse.class))
                 }

            )
        }
    )
    @PostMapping("/payment")
    public ResponseEntity<String> processPayment(tarjeta tarjeta);

}
