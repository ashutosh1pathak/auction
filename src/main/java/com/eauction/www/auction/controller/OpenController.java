package com.eauction.www.auction.controller;

import com.eauction.www.auction.models.Auction;
import com.eauction.www.auction.models.MyUserDetails;
import com.eauction.www.auction.request.models.AuthenticateRequest;
import com.eauction.www.auction.response.models.AuthenticateResponse;
import com.eauction.www.auction.service.MyUserDetailsService;
import com.eauction.www.auction.util.JwtUtil;
import com.eauction.www.auction.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/auctions")
    public Auction getAuctions()
    {
        return Utility.getAuctions().get(0);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticateResponse> auntenticate(@RequestBody AuthenticateRequest authenticateRequest) throws Exception
    {
        try {
            authenticationManager.authenticate
                    (new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername() , authenticateRequest.getPassword()));
        }catch (BadCredentialsException bce)
        {
            throw new Exception("Bad Credential",bce);
        }

        UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticateRequest.getUsername());
        String jwtToken = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticateResponse(jwtToken));


    }


}
