package com.edw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.infinispan.api.annotations.indexing.Basic;
import org.infinispan.api.annotations.indexing.Indexed;
import org.infinispan.api.annotations.indexing.Keyword;

/**
 * <pre>
 *  com.edw.bean.User
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 19 Feb 2025 10:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Indexed
public class User {
    @Keyword(projectable = true, sortable = true, normalizer = "lowercase", indexNullAs = "unnamed", norms = false)
    private String name;

    @Basic(projectable = true, sortable = true, indexNullAs = "0")
    private Integer age;

    @Basic(projectable = true, sortable = true, indexNullAs = "")
    private String address;

    @Basic(projectable = true, sortable = true, indexNullAs = "")
    private String province;
}
