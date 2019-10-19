package com.andre.desafio.rentacar.utils;

import com.andre.desafio.rentacar.enums.SituacaoVagaEnum;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;

import java.io.IOException;

public class SituacaoDeserialize extends StdDeserializer<SituacaoVagaEnum> {

    public SituacaoDeserialize() {
        super(SituacaoVagaEnum.class);
    }

    public SituacaoDeserialize(Class<?> t) {
        super(t);
    }

    @Override
    public SituacaoVagaEnum deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        int codigo = (Integer) ((IntNode) node.get("codigo")).numberValue();
        return SituacaoVagaEnum.valueOf(codigo);
    }


}
