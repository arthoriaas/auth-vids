package com.authvids.security.jwt.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.core.json.JsonReadFeature
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    @Bean
    fun objectMapper(): ObjectMapper {
        val mapper = ObjectMapper()
        mapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.IGNORE_UNDEFINED, true)
        mapper.enable(JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS.mappedFeature())
        return mapper
    }

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        val mappingJackson2HttpMessageConverter = MappingJackson2HttpMessageConverter(objectMapper())
        converters.add(mappingJackson2HttpMessageConverter)
    }
}