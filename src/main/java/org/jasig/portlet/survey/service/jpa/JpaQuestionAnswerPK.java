/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.portlet.survey.service.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the survey_question_answer database table.
 * 
 * @author chasegawa
 * @since 1.0
 */
@Embeddable
class JpaQuestionAnswerPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "ANSWER_ID", insertable = false, updatable = false, nullable = false)
    private long answerId;

    @Column(name = "QUESTION_ID", insertable = false, updatable = false, nullable = false)
    private long questionId;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JpaQuestionAnswerPK)) {
            return false;
        }
        JpaQuestionAnswerPK castOther = (JpaQuestionAnswerPK) other;
        return (this.questionId == castOther.questionId) && (this.answerId == castOther.answerId);
    }

    public long getAnswerId() {
        return this.answerId;
    }

    public long getQuestionId() {
        return this.questionId;
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + ((int) (this.questionId ^ (this.questionId >>> 32)));
        hash = hash * prime + ((int) (this.answerId ^ (this.answerId >>> 32)));

        return hash;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }
}