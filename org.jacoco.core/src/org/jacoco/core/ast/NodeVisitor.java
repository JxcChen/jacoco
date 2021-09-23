/*******************************************************************************
 * Copyright (c) 2009, 2018 Mountainminds GmbH & Co. KG and Contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Marc R. Hoffmann - initial API and implementation
 *
 *******************************************************************************/
package org.jacoco.core.ast;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;

import java.util.ArrayList;
import java.util.List;

public class NodeVisitor extends ASTVisitor {

	public List<ASTNode> nodeList = new ArrayList<ASTNode>();

	@Override
	public void preVisit(ASTNode node) {
		nodeList.add(node);
	}

	public List<ASTNode> getASTNodes() {
		return nodeList;
	}
}
