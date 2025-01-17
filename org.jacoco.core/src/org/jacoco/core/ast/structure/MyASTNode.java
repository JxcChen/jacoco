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
package org.jacoco.core.ast.structure;

import org.eclipse.jdt.core.dom.ASTNode;

public class MyASTNode {
	// 储存ast节点
	public ASTNode astNode = null;

	public int getLineNum() {
		return lineNum;
	}

	public int lineNum = -1;
}
