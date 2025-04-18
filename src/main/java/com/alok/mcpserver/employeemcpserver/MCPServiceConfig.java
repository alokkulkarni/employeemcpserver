package com.alok.mcpserver.employeemcpserver;


import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MCPServiceConfig {

    @Bean
    ToolCallbackProvider toolCallbackProvider(
            EmployeesRepository employeesRepository,
            DepartmentsRepository departmentsRepository,
            ConversationalService conversationalService
    ) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(employeesRepository, departmentsRepository, conversationalService)
                .build();
    }
}
