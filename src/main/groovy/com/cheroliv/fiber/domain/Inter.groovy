package com.cheroliv.fiber.domain

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import java.time.LocalDate
import java.time.LocalTime

import static java.time.format.DateTimeFormatter.ofPattern

@CompileStatic
@Entity
@Table(name = "`Inter`", uniqueConstraints = [
        @UniqueConstraint(
                columnNames = ["ND", "type"],
                name = "uniq_idx_nd_type")])
@ToString
class Inter implements InterConstants, Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_inter")
    Long id
    @Column(name = "ND")
    @NotNull
    @Size(min = 10, max = 10)
    String nd
    @NotNull
    @Pattern(regexp = "BAAP|BAOC|BAFA|BAST|PLP|SAV")
    String type
    @NotNull
    @Pattern(regexp = "LM|IQ|Passage de cable")
    String contrat
    @NotNull
    @Column(columnDefinition = "TIME")
    LocalTime heure
    @Column(columnDefinition = "DATE")
    @NotNull
    LocalDate date
    @Size(max = 100)
    String nom
    @Size(max = 100)
    String prenom

    String[] toArrayString() {
        String[] strings =
                [nd, type, contrat,
                            heure.hour < 10 ? "0${heure.hour}" : heure.hour,
                            date.format(ofPattern("dd/MM/yyyy")),
                            nom.toLowerCase() == "null" || nom == null ? "" : nom,
                            prenom.toLowerCase() == "null" || prenom == null ? "" : prenom]
        strings
    }
    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Inter)) return false

        Inter inter = (Inter) o

        if (contrat != inter.contrat) return false
        if (date != inter.date) return false
        if (heure != inter.heure) return false
        if (nd != inter.nd) return false
        if (nom != inter.nom) return false
        if (prenom != inter.prenom) return false
        if (type != inter.type) return false
        return true
    }

    int hashCode() {
        int result
        result = (nd != null ? nd.hashCode() : 0)
        result = 31 * result + (type != null ? type.hashCode() : 0)
        result = 31 * result + (contrat != null ? contrat.hashCode() : 0)
        result = 31 * result + (heure != null ? heure.hashCode() : 0)
        result = 31 * result + (date != null ? date.hashCode() : 0)
        result = 31 * result + (nom != null ? nom.hashCode() : 0)
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0)
        return result
    }
}
