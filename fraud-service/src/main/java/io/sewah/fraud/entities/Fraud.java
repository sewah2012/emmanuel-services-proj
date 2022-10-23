package io.sewah.fraud.entities;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "frauds")
public class Fraud {
    @Id
    @SequenceGenerator(
            name="fraud_id_sequence",
            sequenceName = "fraud_id_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_id_sequence")
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

}
