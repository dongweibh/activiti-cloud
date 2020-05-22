/*
 * Copyright 2017-2020 Alfresco Software, Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.cloud.services.modeling.jpa;


import org.activiti.cloud.services.modeling.entity.ModelEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * JPA Repository for {@link ModelEntity} entity
 */
@RepositoryRestResource(path = "models",
    collectionResourceRel = "models",
    itemResourceRel = "models",
    exported = false)
public interface ModelJpaRepository extends JpaRepository<ModelEntity, String> {

    @Query("(SELECT m FROM ModelsEntity m WHERE m.project.id = :projectId AND m.type = :modelTypeFilter) UNION "
        + "(SELECT m FROM ModelsEntity m join m.projects p WHERE p.id = :projectId AND m.type = :modelTypeFilter)")
    Page<ModelEntity> findAllByProjectIdAndTypeEquals(String projectId,
        String modelTypeFilter,
        Pageable pageable);


}
