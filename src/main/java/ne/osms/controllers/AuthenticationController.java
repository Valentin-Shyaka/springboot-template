package ne.osms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ne.osms.dtos.SignInDTO;
import ne.osms.payload.ApiResponse;
import ne.osms.payload.JWTAuthenticationResponse;
import ne.osms.security.JwtTokenProvider;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/auth")
@CrossOrigin
public class AuthenticationController {
    
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    
    public AuthenticationController(JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<ApiResponse> login(@Valid @RequestBody SignInDTO signInDTO){
        String jwt = null;
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInDTO.getEmail(),signInDTO.getPassword()));
        try{
            SecurityContextHolder.getContext().setAuthentication(authentication);
            jwt = jwtTokenProvider.generateToken(authentication);
        }
        catch (Exception e){
        }

        return ResponseEntity.ok(ApiResponse.success(new JWTAuthenticationResponse(jwt)));
    }
}
