package itu.mbds.collaborativecommutingapi.services.jwt;

public interface IJwtService {
    String generateToken(String email);
    String extractEmail(String token);

}
