package com.horustek.gda.infra.seguridad.jwt;
/**
 * Class for  JWT Token Settings An RSA type code is used, which requires a public
 * and a private certificate. The token is generated with the public key
 * and with the private key we can verify the integrity of the token.
 *
 * To create de secret code of the token was used RSA algorithm, a certificate
 * that contains a public and a private key. With the private we will sign
 * the token and with the public we verify that the token is valid and has not been modified
 *
 * @author Alejandro Lafourcade
 * @version 1.0
 * date 31/07/2020
 * copyright Grupo Horus
 *
 */

public class JwtConfig {

    public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEpQIBAAKCAQEAxCllNZPHHo9uHND7/eydasw7KjHCnrN3NH+bxsnsLGpxLotf\n" +
            "41lXlj2txg0O5UINtqXr+KPZO7zLcs0APCgnDMoVB6C0s2ygfT7ZzmIvjAeRoS6H\n" +
            "ByD0cb0FZZvpfOBPtSTivi0OSL12KBPE4aliXC6CfjDqcDchjKXuaC1ZjoLxot4U\n" +
            "fwlxDG2SliirgNEXoE6xSgr9KCpcgjoMPMydg0QHfXlk44XmWH2hMOGqXrRRJP7h\n" +
            "nAe9tuB0N4xkknzQLJ+Od3DFdeZXD5M0NuN7roPsNZ9cZp2jpWmaW+O6LNolSYKV\n" +
            "vx3HB+gc8BpLaffAj2zg0C925glOqaJbJ4SRdQIDAQABAoIBAAEjLE8POExZEI5i\n" +
            "N9PVF2STIpSwDSzWZY6MXt7cNN5dD6Lxc/Dhh7x7RxKq6LczltjERYX/jTbndVaJ\n" +
            "EcNHiFJuqYiNyf5wVs3jG2gy8YuiT5nbpzTHYCN4sRtRuBzdQBkQya/ImxiY4KKC\n" +
            "2tVkIgneyyroJbPY3fzuyV8ZRDerUBoJI5LEMiR4B4m9XhtNVtrFsVYkDAD9dkgY\n" +
            "B7V10DWbOVmHA88byfXRnJlUdGcc3GD9GWeoaUc/wZ8cB5y6vquWx/CXxG8iDEwf\n" +
            "rPm/Uwb6XqijeCJ4E7ByyMuD7Xq4hswOTxyHd168ml1ktnNvTiIc1RQXai8BEbQs\n" +
            "ZCQE5oECgYEA4wQNdzRsMej363m+5Ex+n1oiV6VJLkCCeb9thu9uIShlMHlbSlMC\n" +
            "F/iJ1E0q4GSGjdoBHHC+0naVnHKvSQF66SWKZTVrWDz0gVFZzjWZb6STIBQFMHyA\n" +
            "3CakM6jNn4t7aL4sttmOZ4dEM/BJR7ZmN3VIcoUjpCwDbpuwF5AafIkCgYEA3TTi\n" +
            "ZMQIbIBP6/t3Wva3armtn9GiuKX+m6ZLTmdKf3DPX/ECQY4XS/HBqpIpftDoCs4J\n" +
            "oaChNu7A0yTDBX9ASSki88j0kP6u2athFDRJhnIYHaQ18gTq0euWwMV2ccW+uXUI\n" +
            "SMYubi/Q+oR640PmtfUc5D09fY9pGoBonu+jqo0CgYEAuVvKvuVP3mSxYVRz2CbZ\n" +
            "ULWgyt2LZjeIEW6LOJzw2CQKk0zTjFlAoV/u8ijb9IJAFzzEoXsxY9ktiaNemgaa\n" +
            "XBmp6b93WYHTxm8tG6FKGg1Pj+ao4hEWiisG8aNH2Zhi+IAnNFlo3AFnX903iFVX\n" +
            "Grspn1A0bMz/NGXsnyCrb7kCgYEAtFXMy0FVbL8eaM/U+f9wgD1nYodRFR+edd4Y\n" +
            "Po7OmR6qsRiWMkNYkr1AmYIW+h/tTAG0sGN3ioUSBhBOPUkEa6BxsjT9zMcUXLfu\n" +
            "qL4Hwud46ZFZuThxBzn86KMScKY5WpAidNG8QHAS+mjOlkBg8a4mI5wZaSdlFAnj\n" +
            "QM80qnECgYEAizEyd5UJn2ygT5KkSp8AKWBdg/AwRtKX9zcueLBuBbYhX4Vpm5UX\n" +
            "tn/Fb3MYLYT7ReYGvEd8uBcQtZ90u7Jzd8zgUQoAczLYS8Do4XWWAYZ6DceJQSFm\n" +
            "wF1/HHHoNwrObLMyBUAAYeDnlbjM69zZbdHZnn719oa43eD+CUVr2rk=\n" +
            "-----END RSA PRIVATE KEY-----";

    public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxCllNZPHHo9uHND7/eyd\n" +
            "asw7KjHCnrN3NH+bxsnsLGpxLotf41lXlj2txg0O5UINtqXr+KPZO7zLcs0APCgn\n" +
            "DMoVB6C0s2ygfT7ZzmIvjAeRoS6HByD0cb0FZZvpfOBPtSTivi0OSL12KBPE4ali\n" +
            "XC6CfjDqcDchjKXuaC1ZjoLxot4UfwlxDG2SliirgNEXoE6xSgr9KCpcgjoMPMyd\n" +
            "g0QHfXlk44XmWH2hMOGqXrRRJP7hnAe9tuB0N4xkknzQLJ+Od3DFdeZXD5M0NuN7\n" +
            "roPsNZ9cZp2jpWmaW+O6LNolSYKVvx3HB+gc8BpLaffAj2zg0C925glOqaJbJ4SR\n" +
            "dQIDAQAB\n" +
            "-----END PUBLIC KEY-----";
}
