package com.horustek.gda.model.domain.enumeradores;

public enum BienEstadoEnum {
    // Un bien se encuenta pendiente de etiquetado cuando llega al deposito
    // y solamente se tienen los datos de las facturas
    PENDIENTE_ETIQUETADO,

    // Un bien se encuenta PENDIENTE DE APROBACION cuando se le ha puesto la etiqueta
    // y solo falta que el supervisor de la entidad lo revise para que aprueba que el
    // proceso esta bien
    PENDIENTE_APROBACION,

    // Un bien se encuenta PENDIENTE DE ASIGNACION cuando el supervisor ha dado el VoBo
    // y solo falta que se le asigne al responsable
    PENDIENTE_ASIGNACION,

    // Un bien tiene estado ASIGNADO , cuando lo tiene alguien bajo su resposabilidad
    ASIGNADO
}
